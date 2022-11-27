/*
 * Copyright 2015-2022 Alexandr Evstigneev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.perl5.lang.perl.util;

import java.util.Set;


// @todo this interface should be auto-generated from Module::CoreList and has same functionality, like version and deprecation control
public final class PerlCorePackages {

  private PerlCorePackages() {
  }

  public static final String PACKAGE_EXPORTER = "Exporter";
  public static final Set<String> CORE_PACKAGES = Set.of(
    "AnyDBM_File",
    "App::Prove",
    "App::Prove::State",
    "App::Prove::State::Result",
    "App::Prove::State::Result::Test",
    "Archive::Tar",
    "Archive::Tar::File",
    "Attribute::Handlers",
    "AutoLoader",
    "AutoSplit",
    "B",
    "B::Concise",
    "B::Debug",
    "B::Deparse",
    "B::Showlex",
    "B::Terse",
    "B::Xref",
    "Benchmark",
    "Carp",
    "CGI",
    "CGI::Apache",
    "CGI::Carp",
    "CGI::Cookie",
    "CGI::Fast",
    "CGI::Pretty",
    "CGI::Push",
    "CGI::Switch",
    "CGI::Util",
    "Class::Struct",
    "Compress::Raw::Bzip2",
    "Compress::Raw::Zlib",
    "Compress::Zlib",
    "Config",
    "Config::Extensions",
    "CPAN",
    "CPAN::Debug",
    "CPAN::Distroprefs",
    "CPAN::FirstTime",
    "CPAN::HandleConfig",
    "CPAN::Kwalify",
    "CPAN::Nox",
    "CPAN::Queue",
    "CPAN::Tarzip",
    "CPAN::Version",
    "Cwd",
    "Data::Dumper",
    "DB",
    "DBM_Filter",
    "DBM_Filter::compress",
    "DBM_Filter::encode",
    "DBM_Filter::int32",
    "DBM_Filter::null",
    "DBM_Filter::utf8",
    "DB_File",
    "Devel::Peek",
    "Devel::PPPort",
    "Devel::SelfStubber",
    "Digest",
    "Digest::base",
    "Digest::file",
    "Digest::MD5",
    "Digest::SHA",
    "DirHandle",
    "Dumpvalue",
    "DynaLoader",
    "Encode",
    "Encode::Alias",
    "Encode::Byte",
    "Encode::CJKConstants",
    "Encode::CN",
    "Encode::CN::HZ",
    "Encode::Config",
    "Encode::EBCDIC",
    "Encode::Encoder",
    "Encode::Encoding",
    "Encode::GSM0338",
    "Encode::Guess",
    "Encode::JP",
    "Encode::JP::H2Z",
    "Encode::JP::JIS7",
    "Encode::KR",
    "Encode::KR::2022_KR",
    "Encode::MIME::Header",
    "Encode::MIME::Name",
    "Encode::Symbol",
    "Encode::TW",
    "Encode::Unicode",
    "Encode::Unicode::UTF7",
    "English",
    "Env",
    "Errno",
    PACKAGE_EXPORTER,
    "Exporter::Heavy",
    "ExtUtils::CBuilder",
    "ExtUtils::CBuilder::Platform::Windows",
    "ExtUtils::Command",
    "ExtUtils::Command::MM",
    "ExtUtils::Constant",
    "ExtUtils::Constant::Base",
    "ExtUtils::Constant::Utils",
    "ExtUtils::Constant::XS",
    "ExtUtils::Embed",
    "ExtUtils::Install",
    "ExtUtils::Installed",
    "ExtUtils::Liblist",
    "ExtUtils::MakeMaker",
    "ExtUtils::MakeMaker::Config",
    "ExtUtils::MakeMaker::FAQ",
    "ExtUtils::MakeMaker::Tutorial",
    "ExtUtils::Manifest",
    "ExtUtils::Miniperl",
    "ExtUtils::Mkbootstrap",
    "ExtUtils::Mksymlists",
    "ExtUtils::MM",
    "ExtUtils::MM_AIX",
    "ExtUtils::MM_Any",
    "ExtUtils::MM_BeOS",
    "ExtUtils::MM_Cygwin",
    "ExtUtils::MM_Darwin",
    "ExtUtils::MM_DOS",
    "ExtUtils::MM_MacOS",
    "ExtUtils::MM_NW5",
    "ExtUtils::MM_OS2",
    "ExtUtils::MM_QNX",
    "ExtUtils::MM_Unix",
    "ExtUtils::MM_UWIN",
    "ExtUtils::MM_VMS",
    "ExtUtils::MM_VOS",
    "ExtUtils::MM_Win32",
    "ExtUtils::MM_Win95",
    "ExtUtils::MY",
    "ExtUtils::Packlist",
    "ExtUtils::ParseXS",
    "ExtUtils::testlib",
    "Fatal",
    "Fcntl",
    "File::Basename",
    "File::Compare",
    "File::Copy",
    "File::DosGlob",
    "File::Fetch",
    "File::Find",
    "File::Glob",
    "File::GlobMapper",
    "File::Path",
    "File::Spec",
    "File::Spec::Cygwin",
    "File::Spec::Epoc",
    "File::Spec::Functions",
    "File::Spec::Mac",
    "File::Spec::OS2",
    "File::Spec::Unix",
    "File::Spec::VMS",
    "File::Spec::Win32",
    "File::stat",
    "File::Temp",
    "FileCache",
    "FileHandle",
    "Filter::Simple",
    "Filter::Util::Call",
    "FindBin",
    "Getopt::Long",
    "Getopt::Std",
    "Hash::Util",
    "Hash::Util::FieldHash",
    "I18N::Collate",
    "I18N::Langinfo",
    "I18N::LangTags",
    "I18N::LangTags::Detect",
    "I18N::LangTags::List",
    "IO",
    "IO::Compress::Base",
    "IO::Compress::Bzip2",
    "IO::Compress::Deflate",
    "IO::Compress::Gzip",
    "IO::Compress::RawDeflate",
    "IO::Compress::Zip",
    "IO::Dir",
    "IO::File",
    "IO::Handle",
    "IO::Pipe",
    "IO::Poll",
    "IO::Seekable",
    "IO::Select",
    "IO::Socket",
    "IO::Socket::INET",
    "IO::Socket::UNIX",
    "IO::Uncompress::AnyInflate",
    "IO::Uncompress::AnyUncompress",
    "IO::Uncompress::Base",
    "IO::Uncompress::Bunzip2",
    "IO::Uncompress::Gunzip",
    "IO::Uncompress::Inflate",
    "IO::Uncompress::RawInflate",
    "IO::Uncompress::Unzip",
    "IO::Zlib",
    "IPC::Cmd",
    "IPC::Msg",
    "IPC::Open2",
    "IPC::Open3",
    "IPC::Semaphore",
    "IPC::SharedMem",
    "IPC::SysV",
    "List::Util",
    "List::Util::XS",
    "Locale::Country",
    "Locale::Currency",
    "Locale::Language",
    "Locale::Maketext",
    "Locale::Maketext::Simple",
    "Locale::Script",
    "Math::BigFloat",
    "Math::BigInt",
    "Math::BigInt::Calc",
    "Math::BigInt::CalcEmu",
    "Math::BigInt::FastCalc",
    "Math::BigRat",
    "Math::Complex",
    "Math::Trig",
    "Memoize",
    "Memoize::AnyDBM_File",
    "Memoize::Expire",
    "Memoize::ExpireFile",
    "Memoize::ExpireTest",
    "Memoize::NDBM_File",
    "Memoize::SDBM_File",
    "Memoize::Storable",
    "MIME::Base64",
    "MIME::QuotedPrint",
    "Module::Build",
    "Module::Build::Base",
    "Module::Build::Compat",
    "Module::Build::ConfigData",
    "Module::Build::Cookbook",
    "Module::Build::Notes",
    "Module::Build::Platform::aix",
    "Module::Build::Platform::cygwin",
    "Module::Build::Platform::darwin",
    "Module::Build::Platform::Default",
    "Module::Build::Platform::MacOS",
    "Module::Build::Platform::os2",
    "Module::Build::Platform::Unix",
    "Module::Build::Platform::VMS",
    "Module::Build::Platform::VOS",
    "Module::Build::Platform::Windows",
    "Module::Build::PPMMaker",
    "Module::CoreList",
    "Module::Load",
    "Module::Load::Conditional",
    "Module::Loaded",
    "NDBM_File",
    "Net::Cmd",
    "Net::Config",
    "Net::Domain",
    "Net::FTP",
    "Net::hostent",
    "Net::netent",
    "Net::Netrc",
    "Net::NNTP",
    "Net::Ping",
    "Net::POP3",
    "Net::protoent",
    "Net::servent",
    "Net::SMTP",
    "Net::Time",
    "NEXT",
    "O",
    "Opcode",
    "Package::Constants",
    "Params::Check",
    "Parse::CPAN::Meta",
    "PerlIO",
    "PerlIO::encoding",
    "PerlIO::scalar",
    "PerlIO::via",
    "PerlIO::via::QuotedPrint",
    "Pod::Checker",
    "Pod::Escapes",
    "Pod::Find",
    "Pod::Functions",
    "Pod::Html",
    "Pod::InputObjects",
    "Pod::Man",
    "Pod::ParseLink",
    "Pod::Parser",
    "Pod::ParseUtils",
    "Pod::Perldoc",
    "Pod::Perldoc::BaseTo",
    "Pod::Perldoc::GetOptsOO",
    "Pod::Perldoc::ToChecker",
    "Pod::Perldoc::ToMan",
    "Pod::Perldoc::ToNroff",
    "Pod::Perldoc::ToPod",
    "Pod::Perldoc::ToRtf",
    "Pod::Perldoc::ToText",
    "Pod::Perldoc::ToTk",
    "Pod::Perldoc::ToXml",
    "Pod::PlainText",
    "Pod::Select",
    "Pod::Simple",
    "Pod::Simple::Checker",
    "Pod::Simple::Debug",
    "Pod::Simple::DumpAsText",
    "Pod::Simple::DumpAsXML",
    "Pod::Simple::HTML",
    "Pod::Simple::HTMLBatch",
    "Pod::Simple::LinkSection",
    "Pod::Simple::Methody",
    "Pod::Simple::PullParser",
    "Pod::Simple::PullParserEndToken",
    "Pod::Simple::PullParserStartToken",
    "Pod::Simple::PullParserTextToken",
    "Pod::Simple::PullParserToken",
    "Pod::Simple::RTF",
    "Pod::Simple::Search",
    "Pod::Simple::SimpleTree",
    "Pod::Simple::Text",
    "Pod::Simple::TextContent",
    "Pod::Simple::XHTML",
    "Pod::Simple::XMLOutStream",
    "Pod::Text",
    "Pod::Text::Color",
    "Pod::Text::Overstrike",
    "Pod::Text::Termcap",
    "Pod::Usage",
    "POSIX",
    "Safe",
    "Scalar::Util",
    "SDBM_File",
    "Search::Dict",
    "SelectSaver",
    "SelfLoader",
    "Socket",
    "Storable",
    "Symbol",
    "Sys::Hostname",
    "Sys::Syslog",
    "TAP::Base",
    "TAP::Formatter::Base",
    "TAP::Formatter::Color",
    "TAP::Formatter::Console",
    "TAP::Formatter::Console::ParallelSession",
    "TAP::Formatter::Console::Session",
    "TAP::Formatter::File",
    "TAP::Formatter::File::Session",
    "TAP::Formatter::Session",
    "TAP::Harness",
    "TAP::Object",
    "TAP::Parser",
    "TAP::Parser::Aggregator",
    "TAP::Parser::Grammar",
    "TAP::Parser::Iterator",
    "TAP::Parser::Iterator::Array",
    "TAP::Parser::Iterator::Process",
    "TAP::Parser::Iterator::Stream",
    "TAP::Parser::IteratorFactory",
    "TAP::Parser::Multiplexer",
    "TAP::Parser::Result",
    "TAP::Parser::Result::Bailout",
    "TAP::Parser::Result::Comment",
    "TAP::Parser::Result::Plan",
    "TAP::Parser::Result::Pragma",
    "TAP::Parser::Result::Test",
    "TAP::Parser::Result::Unknown",
    "TAP::Parser::Result::Version",
    "TAP::Parser::Result::YAML",
    "TAP::Parser::ResultFactory",
    "TAP::Parser::Scheduler",
    "TAP::Parser::Scheduler::Job",
    "TAP::Parser::Scheduler::Spinner",
    "TAP::Parser::Source",
    "TAP::Parser::YAMLish::Reader",
    "TAP::Parser::YAMLish::Writer",
    "Term::ANSIColor",
    "Term::Cap",
    "Term::Complete",
    "Term::ReadLine",
    "Test",
    "Test::Builder",
    "Test::Builder::Module",
    "Test::Builder::Tester",
    "Test::Builder::Tester::Color",
    "Test::Harness",
    "Test::More",
    "Test::Simple",
    "Text::Abbrev",
    "Text::Balanced",
    "Text::ParseWords",
    "Text::Tabs",
    "Text::Wrap",
    "Thread",
    "Thread::Queue",
    "Thread::Semaphore",
    "Tie::Array",
    "Tie::File",
    "Tie::Handle",
    "Tie::Hash",
    "Tie::Hash::NamedCapture",
    "Tie::Memoize",
    "Tie::RefHash",
    "Tie::Scalar",
    "Tie::StdHandle",
    "Tie::SubstrHash",
    "Time::gmtime",
    "Time::HiRes",
    "Time::Local",
    "Time::localtime",
    "Time::Piece",
    "Time::Seconds",
    "Time::tm",
    "Unicode::Collate",
    "Unicode::Normalize",
    "Unicode::UCD",
    PerlPackageUtil.UNIVERSAL_NAMESPACE,
    "User::grent",
    "User::pwent",
    "XSLoader",
    PerlPackageUtil.MAIN_NAMESPACE_NAME,
    PerlPackageUtil.CORE_NAMESPACE
  );

  public static final Set<String> CORE_PACKAGES_PRAGMAS = Set.of(
    "attributes",
    "autodie",
    "autodie::exception",
    "autodie::exception::system",
    "autodie::hints",
    "autodie::skip",
    "autouse",
    "base",
    "bigfloat",
    "bigint",
    "bignum",
    "bigrat",
    "blib",
    "builtin",
    "bytes",
    "charnames",
    "constant",
    "deprecate",
    "diagnostics",
    "encoding",
    "encoding::warnings",
    "experimental",
    "feature",
    "fields",
    "filetest",
    "if",
    "integer",
    "less",
    "lib",
    "locale",
    "mro",
    "ok",
    "open",
    "ops",
    "overload",
    "overloading",
    "parent",
    "re",
    "sigtrap",
    "sort",
    "strict",
    "subs",
    "threads",
    "threads::shared",
    "utf8",
    "vars",
    "version",
    "vmsish",
    "warnings",
    "warnings::register"
  );

  public static final Set<String> CORE_PACKAGES_DEPRECATED = Set.of(
    "Locale::Maketext::Guts",
    "Locale::Maketext::GutsLoader",
    "Module::Build::ModuleInfo",
    "Module::Build::Version",
    "Module::Build::YAML"
  );
}
